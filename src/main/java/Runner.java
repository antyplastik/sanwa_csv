public class Runner {

    public static void main(String[] args) {

        String testStr = "00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,";

        PClink7CSVfix csVfixer = new PClink7CSVfix(testStr);
//        System.out.println(csVfixer.parseLine(testStr));
        System.out.println(csVfixer.fixLine());

    }

}
