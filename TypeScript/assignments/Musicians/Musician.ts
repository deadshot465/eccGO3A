import { getRandomNumber } from "../../shared/Utility.ts"

export enum SkillLevel {
    Good, Bad
}

export class Musician {
    #name: string;
    #role: string;
    #skillLevel: SkillLevel;
    #isFired = false;

    static #firstNames = ["Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
    "Janet", "Leo", "Yuhei", "Carson"];

    static #lastNames = ["Frizzle",
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
    "Hage"];
    
    constructor(role: string, skillLevel: SkillLevel) {
        this.#name = Musician.pickName();
        this.#role = role;
        this.#skillLevel = skillLevel;
        console.log(`Musician ${this.#name}, playing the ${this.#role} entered the room.`);
    }

    playSound(): boolean {
        if (this.#isFired) {
            console.log(`${this.#name} just got back to playing in the subway.`);
            return false;
        }

        switch (this.#skillLevel) {
            case SkillLevel.Good:
                console.log(`${this.#name} produced sound!`);
                return true;
            case SkillLevel.Bad:
                {
                    const failed = getRandomNumber(5) == 0;
                    if (failed) {
                        console.log(`${this.#name} played a false note. Uh oh.`);
                        console.log(`${this.#name} sucks! kicked that member out of the band! (${this.#role})`);
                    } else {
                        console.log(`${this.#name} produced sound!`);
                    }
                    
                    return !failed;
                }
        }
    }

    get role(): string {
        return this.#role;
    }

    get skillLevel(): SkillLevel {
        return this.#skillLevel;
    }

    setFired() {
        this.#isFired = true;
    }

    private static pickName(): string {
        const firstName = this.#firstNames[getRandomNumber(this.#firstNames.length)];
        const lastName = this.#lastNames[getRandomNumber(this.#lastNames.length)];
        return firstName + " " + lastName;
    }
}