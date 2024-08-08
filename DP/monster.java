package localrepo.DP;

import java.util.*;

public class monster {

    static class Monster {
        int power;
        int bonus;

        Monster(int power, int bonus) {
            this.power = power;
            this.bonus = bonus;
        }
    }

    public static int maxMonstersDefeated(int n, int e, int[] powers, int[] bonuses) {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monsters.add(new Monster(powers[i], bonuses[i]));
        }

        // Sort monsters by power
        Collections.sort(monsters, Comparator.comparingInt(m -> m.power));

        int defeated = 0;
        for (Monster monster : monsters) {
            if (e >= monster.power) {
                e += monster.bonus;
                defeated++;
            } else {
                break;
            }
        }

        return defeated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int[] powers = new int[n];
        int[] bonuses = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bonuses[i] = scanner.nextInt();
        }

        int result = maxMonstersDefeated(n, e, powers, bonuses);
        System.out.println("You defeated " + result + " monsters!!");
    }
}
