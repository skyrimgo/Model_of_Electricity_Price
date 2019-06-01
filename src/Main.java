/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        ElectricityGeneration electricityGeneration = new ElectricityGeneration();
        electricityGeneration.init();
        ElectricitySupply electricitySupply = new ElectricitySupply();
        electricitySupply.init();
        GA_ElectricityGeneration ga_ElectricityGeneration = new GA_ElectricityGeneration();
        GA_ElectricitySupply ga_ElectricitySupply = new GA_ElectricitySupply();
        ElectricityUsers electricityUsers = new ElectricityUsers();
        double[] q_array = { 1224, 980, 1824 };
        double[] p_f_array = { 0.0735, 0.2880, 0.4365 };
        double[] p_g_array = { 0.1628, 0.4732, 0.7083, 0.1628, 0.4732, 0.7083 };
        for (int i = 1; i <= 5; i++) {
            System.out.println("第" + i + "次博弈：");
            p_f_array = ga_ElectricityGeneration.run(q_array[0], q_array[1], q_array[2]);
            p_g_array = ga_ElectricitySupply.run(p_f_array[0], p_f_array[1], p_f_array[2], p_g_array);
            q_array = electricityUsers.run(p_g_array[0], p_g_array[1], p_g_array[2], p_g_array[3], p_g_array[4],
                    p_g_array[5], q_array[0], q_array[1], q_array[2]);

        }
    }

}