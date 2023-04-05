package org.example.yy;

import org.example.Appender;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
┌───────────── minute (0 - 59)
│ ┌───────────── hour (0 - 23)
│ │ ┌───────────── day of the month (1 - 31)
│ │ │ ┌───────────── month (1 - 12 or JAN-DEC)
│ │ │ │ ┌───────────── day of the week (0 - 6 or SUN-SAT)
│ │ │ │ │
│ │ │ │ │
│ │ │ │ │
* * * * *
	*/
public class Cron extends Tag {
	Set<CronItem> minutes = new LinkedHashSet<>();
	Set<CronItem> hours = new LinkedHashSet<>();
	Set<CronItem> days = new LinkedHashSet<>();
	Set<CronItem> months = new LinkedHashSet<>();
	Set<CronItem> daysOfWeek = new LinkedHashSet<>();
	
	
	Predicate<Integer> minutesPredicate = i -> i >= 0 && i <= 59;
	Predicate<Integer> hoursPredicate = i -> i >= 0 && i <= 23;
	Predicate<Integer> daysPredicate = i -> i >= 1 && i <= 31;
	Predicate<Integer> monthsPredicate = i -> i >= 1 && i <= 12;
	Predicate<Integer> dayOfTheWeekPredicate = i -> i >= 1 && i <= 6;
	
	public static Cron $() {
		return new Cron();
	}
	
	private Cron conditionalAdd(Predicate<Integer> predicate,
								Set<CronItem> destination,
								CronItem... elements) {
		for (CronItem item : elements) {
			if (item.apply(predicate)) {
				destination.add(item);
			}
		}
		return this;
	}
	
	private List<CronItem> getCronItems(Integer[] inputs, Predicate<Integer> predicate) {
		List<CronItem> elements = new ArrayList<>();
		for (Integer input : inputs) {
			if (predicate.test(input)) {
				elements.add(new Singleton(input));
			}
		}
		return elements;
	}
	
	public Cron minutes(Integer... minutes) {
		List<CronItem> elements = getCronItems(minutes, minutesPredicate);
		this.minutes.addAll(elements);
		return this;
	}
	
	public Cron minutes(Periodic... periodics) {
		return conditionalAdd(minutesPredicate, this.minutes, periodics);
	}
	
	public Cron minutes(CronItem... cronItems) {
		return conditionalAdd(minutesPredicate, this.minutes, cronItems);
	}
	
	public Cron minutes(Range... ranges) {
		return conditionalAdd(minutesPredicate, this.minutes, ranges);
	}
	
	public Cron hours(Integer... hours) {
		List<CronItem> elements = getCronItems(hours, hoursPredicate);
		this.hours.addAll(elements);
		return this;
	}
	
	public Cron hours(Periodic... periodics) {
		return conditionalAdd(hoursPredicate, this.hours, periodics);
	}
	
	public Cron hours(Range... ranges) {
		return conditionalAdd(hoursPredicate, this.hours, ranges);
	}
	
	public Cron hours(CronItem... items) {
		return conditionalAdd(hoursPredicate, this.hours, items);
	}
	
	public Cron day(Integer... days) {
		List<CronItem> elements = getCronItems(days, daysPredicate);
		this.days.addAll(elements);
		return this;
	}
	
	public Cron day(Periodic... periodics) {
		return conditionalAdd(daysPredicate, this.days, periodics);
	}
	
	public Cron day(Range... ranges) {
		return conditionalAdd(daysPredicate, this.days, ranges);
	}
	
	public Cron day(CronItem... days) {
		return conditionalAdd(daysPredicate, this.days, days);
	}
	
	public Cron month(Integer... months) {
		List<CronItem> elements = getCronItems(months, monthsPredicate);
		this.months.addAll(elements);
		return this;
	}
	
	public Cron month(Periodic... periodics) {
		return conditionalAdd(monthsPredicate, this.months, periodics);
	}
	
	public Cron month(Range... ranges) {
		return conditionalAdd(monthsPredicate, this.months, ranges);
	}
	
	public Cron month(CronItem... cronItems) {
		return conditionalAdd(monthsPredicate, this.months, cronItems);
	}
	
	public Cron dayOfweek(Integer... dayOfweek) {
		List<CronItem> elements = getCronItems(dayOfweek, dayOfTheWeekPredicate);
		this.daysOfWeek.addAll(elements);
		return this;
	}
	
	public Cron dayOfweek(Range... ranges) {
		return conditionalAdd(dayOfTheWeekPredicate, this.daysOfWeek, ranges);
	}
	
	public Cron dayOfweek(Periodic... ranges) {
		return conditionalAdd(dayOfTheWeekPredicate, this.daysOfWeek, ranges);
	}
	
	public Cron dayOfweek(CronItem... cronItems) {
		return conditionalAdd(dayOfTheWeekPredicate, this.daysOfWeek, cronItems);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		
		Appender appender = new Appender();
		String mins = joinEntry(minutes);
		String hrs = joinEntry(hours);
		String dys = joinEntry(days);
		String mths = joinEntry(months);
		String dysWeek = joinEntry(daysOfWeek);
		
		appender.append(mins);
		appender.append(" ");
		appender.append(hrs);
		appender.append(" ");
		appender.append(dys);
		appender.append(" ");
		appender.append(mths);
		appender.append(" ");
		appender.append(dysWeek);
		return appender.toString();
	}
	
	private String joinEntry(Set<?> entries) {
		if (entries.isEmpty())
			return "*";
		return entries.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
	}
	
	public static class Periodic implements CronItem {
		int every;
		int from;
		
		public Periodic from(int from) {
			this.from = from;
			return this;
		}
		
		public Periodic every(int every) {
			this.every = every;
			return this;
		}
		
		public static Periodic $() {
			return new Periodic();
		}
		
		@Override
		public boolean apply(Predicate<Integer> predicate) {
			return from >= 0 && every > 0
					&& (from == 0 || predicate.test(from));
		}
		
		@Override
		public String toString() {
			if (from == 0) {
				return "*/" + every;
			}
			return from + "/" + every;
		}
	}
	
	public static class Range implements CronItem {
		int from;
		int to;
		
		public static Range $() {
			return new Range();
		}
		
		public Range from(int from) {
			this.from = from;
			return this;
		}
		
		public Range to(int to) {
			this.to = to;
			return this;
		}
		
		@Override
		public String toString() {
			return from + "-" + to;
		}
		
		
		@Override
		public boolean apply(Predicate<Integer> predicate) {
			return from >= 0 && from <= to
					&& predicate.test(from)
					&& predicate.test(to);
		}
	}
	
	private static class Singleton implements CronItem {
		final Integer value;
		
		private Singleton(Integer value) {this.value = value;}
		
		@Override
		public boolean apply(Predicate<Integer> predicate) {
			return value != null && predicate.test(value);
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}
	
	public interface CronItem {
		
		boolean apply(Predicate<Integer> predicate);
	}
	
	enum DaysOfWeek implements CronItem {
		SUN,
		MON,
		TUE,
		WED,
		THU,
		FRI,
		SAT,
		;
		
		@Override
		public boolean apply(Predicate<Integer> predicate) {
			return true;
		}
	}
}
