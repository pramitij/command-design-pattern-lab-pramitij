package edu.neu.csye7374;
import java.util.ArrayList;
import java.util.List;

public class Command {

    static class AddCommand implements CommandAPI {
        private final double num1;
        private final double num2;

        public AddCommand(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double execute() {
            return num1 + num2;
        }
    }

    static class SubtractCommand implements CommandAPI {
        private final double num1;
        private final double num2;

        public SubtractCommand(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double execute() {
            return num1 - num2;
        }
    }

    static class MultiplyCommand implements CommandAPI {
        private final double num1;
        private final double num2;

        public MultiplyCommand(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double execute() {
            return num1 * num2;
        }
    }

    static class DivideCommand implements CommandAPI {
        private final double num1;
        private final double num2;

        public DivideCommand(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double execute() {
            return num1 / num2;
        }
    }

    static class SumCommand implements CommandAPI {
        private final List<Double> nums;

        public SumCommand(List<Double> nums) {
            this.nums = nums;
        }

        @Override
        public double execute() {
            double sum = 0;
            for (double num : nums) {
                sum += num;
            }
            return sum;
        }
    }

    static class BatchCalculator {
        private final List<CommandAPI> commands;

        public BatchCalculator(List<CommandAPI> commands) {
            this.commands = commands;
        }

        public List<Double> compute() {
            List<Double> results = new ArrayList<>();
            for (CommandAPI command : commands) {
                results.add(command.execute());
            }
            return results;
        }
    }

    public static void Demo() {
        Command.BatchCalculator batchCalculator = new Command.BatchCalculator(List.of(
                new Command.AddCommand(6.0, 3.0),
                new Command.SubtractCommand(6.0, 3.0),
                new Command.MultiplyCommand(6.0, 3.0),
                new Command.DivideCommand(6.0, 3.0),
                new Command.SumCommand(List.of(1.0, 2.0, 3.0, 4.0))
        ));

        List<Double> results = batchCalculator.compute();
        System.out.println("Results:");
        for (double result : results) {
            System.out.println(result);
        }
    }

}
