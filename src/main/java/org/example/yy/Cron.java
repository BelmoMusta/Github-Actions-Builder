package org.example.yy;

import org.example.Appender;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.Tag;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntPredicate;
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
	Set<Integer> minutes = new TreeSet<>();
	Set<Integer> minutes_ = new TreeSet<>();
	Set<Integer> hour = new TreeSet<>();
	Set<Integer> day = new TreeSet<>();
	Set<Integer> month = new TreeSet<>();
	Set<Integer> dayOfweek = new TreeSet<>();
	
	static Map<String, Integer> DAYS_OF_WEEK = new LinkedHashMap<>();
	
	static Map<String, Integer> MONTHS = new LinkedHashMap<>();
	
	static {
		DAYS_OF_WEEK.put("SUN", 0);
		DAYS_OF_WEEK.put("MON", 1);
		DAYS_OF_WEEK.put("TUE", 2);
		DAYS_OF_WEEK.put("WED", 3);
		DAYS_OF_WEEK.put("THU", 4);
		DAYS_OF_WEEK.put("FRI", 5);
		DAYS_OF_WEEK.put("SAT", 6);
		
		MONTHS.put("JAN", 1);
		MONTHS.put("FEB", 2);
		MONTHS.put("MAR", 3);
		MONTHS.put("APR", 4);
		MONTHS.put("MAY", 5);
		MONTHS.put("JUN", 6);
		MONTHS.put("JUL", 7);
		MONTHS.put("AUG", 8);
		MONTHS.put("SEP", 9);
		MONTHS.put("OCT", 10);
		MONTHS.put("NOV", 11);
		MONTHS.put("DEC", 12);
	}
	
	IntPredicate minutesPredicate = i -> i >= 0 && i <= 59;
	IntPredicate hoursPredicate = i -> i >= 0 && i <= 23;
	IntPredicate daysPredicate = i -> i >= 1 && i <= 31;
	IntPredicate monthsPredicate = i -> i >= 1 && i <= 12;
	IntPredicate dayOfTheWeekPredicate = i -> i >= 1 && i <= 6;
	
	public static Cron $() {
		return new Cron();
	}
	
	private Cron conditionalAdd(IntPredicate predicate, Set<Integer> destination, Integer... elements) {
		for (Integer minute : elements) {
			if (predicate.test(minute)) {
				destination.add(minute);
			}
		}
		return this;
	}
	
	public Cron minutes(Integer... minutes) {
		return conditionalAdd(minutesPredicate, this.minutes, minutes);
	}
	
	public Cron hour(Integer... hour) {
		return conditionalAdd(hoursPredicate, this.hour, hour);
	}
	
	public Cron day(Integer... day) {
		return conditionalAdd(daysPredicate, this.day, day);
	}
	
	public Cron month(Integer... month) {
		return conditionalAdd(monthsPredicate, this.month, month);
	}
	
	public Cron month(String month) {
		//	this.month = MONTHS.getOrDefault(month, -1);
		return this;
	}
	
	public Cron dayOfweek(Integer... dayOfweek) {
		return conditionalAdd(dayOfTheWeekPredicate, this.dayOfweek, dayOfweek);
	}
	
	public Cron dayOfweek(String dayOfweek) {
		//	this.dayOfweek = DAYS_OF_WEEK.getOrDefault(dayOfweek, -1);
		return this;
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
		String hrs = joinEntry(hour);
		String dys = joinEntry(day);
		String mths = joinEntry(month);
		String dysWeek = joinEntry(dayOfweek);
		
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
	
	private String joinEntry(Set<Integer> entries) {
		if (entries.isEmpty())
			return "*";
		return entries.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
	}
}
