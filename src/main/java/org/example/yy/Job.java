package org.example.yy;

import org.example.collections.Needs;
import org.example.collections.Nodes;
import org.example.collections.Outputs;
import org.example.collections.Services;
import org.example.collections.Steps;
import org.example.visitor.Visitor;
import org.example.wrappers.Node;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.If;
import org.example.wrappers.leaves.LabeledName;
import org.example.wrappers.leaves.NameValuePair;
import org.example.wrappers.leaves.Output;
import org.example.wrappers.leaves.RunsOn;
import org.example.wrappers.leaves.SingleElement;
import org.example.yy.support.EnvSupport;

import java.util.Arrays;
import java.util.List;

public class Job extends Nodes implements EnvSupport {
    public Node label;

    public Job() {
        super(null);
    }

    public static Job $() {
        return new Job();
    }
    public static Job $(String label) {
        Job job = new Job();
        return job.label(label);
    }

    public Job label(String label) {
        this.label = new SingleElement(label);
        return this;
    }

    public Job name(String name) {
        this.add(new LabeledName(name));
        return this;
    }

    public Job runsOn(String s) {
        add(new RunsOn(s));
        return this;
    }

    public Job runsOnUbuntuLatest() {
        return runsOn("ubuntu-latest");
    }

    public Job id(String id) {
        class Id extends NameValuePair {
            Id(String id) {
                super("id", id);
            }
        }
        Id existingId = findTag(Id.class);
        if (existingId == null) {
            Id idToBe = new Id(id);
            add(idToBe);
        }
        return this;
    }

    public Job steps(Step... steps) {
        for (Step step : steps) {
            step(step);
        }
        return this;
    }
    public Job step(Step step) {
        Steps steps = findTag(Steps.class);
        if (steps == null) {
            steps = new Steps();
            add(steps);
        }
        steps.add(step);
        return this;
    }

    private Job needs(List<String> jobs) {
        Needs needs = findTag(Needs.class);
        if (needs == null) {
            needs = new Needs();
            add(needs);
        }
        for (String job : jobs) {
            needs.add(new DashSingleElement(job));

        }
        return this;
    }

    public Job needs(String... jobs) {
        return needs(Arrays.asList(jobs));
    }

    public Job env(String name, String value) {
        return getEnv(this, name, value);
    }

    public Job if_(String condition) {
        add(new If(condition));
        return this;
    }


    public Job outputs(Output... outputs) {

        Outputs outs = new Outputs();
        for (Output input : outputs) {
            outs.add(input);
        }
        add(outs);
        return this;
    }

    public Job container(Container container) {
        this.add(container);
        return this;
    }

    public Job service(Service... services) {
        Services innerServices = findTag(Services.class);
        if (innerServices == null) {
            innerServices = new Services();
            add(innerServices);
        }
        for (Service service : services) {
            innerServices.add(service);
        }
        return this;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public Job cancelTimeOutMinutes(int minutes) {
        add(new NameValuePair("cancel-timeout-minutes", String.valueOf(minutes)));
        return this;
    }

    public Job concurrency(Concurrency concurrency) {
        add(concurrency);
        return this;
    }

    public Job environment(String evironment) {
        return this;
    }

    public Job continueOnError(boolean continueOnError) {
        this.add(new NameValuePair("continue-on-error", String.valueOf(continueOnError)));
        return this;
    }

    public Job defaults(Defaults defaults) {
        this.add(defaults);
        return this;
    }

    public Job permissions(Permissions permissions) {
        add(permissions);
        return this;
    }

    public Job strategy(Strategy strategy) {
        add(strategy);
        return this;
    }
}
