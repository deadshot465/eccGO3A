package io.github.deadshot465.assignments.musicians;

import java.util.Random;

public class Musician {
    public static final int delay = 750;

    private final String name;
    private final String role;
    private final SkillLevel skillLevel;
    private boolean isFired;

    private static final String[] firstNames = new String[] {
            "Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
            "Janet", "Leo", "Yuhei", "Carson"
    };

    private static final String[] lastNames = new String[]{
            "Frizzle",
            "Perlstein",
            "Ramon",
            "Ann",
            "Franklin",
            "Terese",
            "Tennelli",
            "Jamal",
            "Li",
            "Perlstein",
            "Fujioka",
            "Ito",
            "Hage"
    };

    public Musician(String role, SkillLevel skillLevel) {
        this.name = pickName();
        this.role = role;
        this.skillLevel = skillLevel;
        this.isFired = false;

        System.out.printf("Musician %s, playing the %s entered the room.\n", name, role);
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public boolean playSound() {
        if (isFired) {
            System.out.printf("%s just got back to playing in the subway.\n", name);
            return false;
        }

        switch (skillLevel) {
            case Good -> {
                System.out.printf("%s produced sound!\n", name);
                return true;
            }
            case Bad -> {
                final var rng = new Random();
                final var failed = rng.nextInt(0, 5) == 0;
                if (failed) {
                    System.out.printf("%s played a false note. Uh oh.\n", name);
                    System.out.printf("%s sucks! kicked that member out of the band! (%s)\n", name, role);
                } else {
                    System.out.printf("%s produced sound!\n", name);
                }

                return !failed;
            }
            default -> {
                return true;
            }
        }
    }

    private static String pickName() {
        final var rng = new Random();
        final var firstName = firstNames[rng.nextInt(0, firstNames.length)];
        final var lastName = lastNames[rng.nextInt(0, lastNames.length)];
        return firstName + " " + lastName;
    }
}
