import { Musician, SkillLevel } from "./Musician.ts";

const delay = 750;

let identifier = 0;

export function startBand(maxRetries: number) {
    const members = new Map<string, Musician>();
    members.set("singer", addBandMember("singer", SkillLevel.Good));
    members.set("bass", addBandMember("bass", SkillLevel.Good));
    members.set("drum", addBandMember("drum", SkillLevel.Bad));
    members.set("guitar", addBandMember("guitar", SkillLevel.Good));

    const stopInterval = () => {
        if (maxRetries <= 0) {
            clearInterval(identifier);
        }
    }

    identifier = setInterval(() => {
        for (const member of members) {
            const playResult = member[1].playSound();
            if (playResult) {
                continue;
            }

            if (maxRetries <= 0) {
                continue;
            }

            maxRetries--;
            if (maxRetries <= 0) {
                console.log("The manager is mad and fired the whole band!");
                for (const m of members) {
                    m[1].setFired();
                }
                return;
            }

            const {role, skillLevel} = member[1];
            members.delete(role);
            members.set(role, addBandMember(role, skillLevel));
        }
        stopInterval();
    }, delay);
} 

function addBandMember(role: string, skillLevel: SkillLevel): Musician {
    const musician = new Musician(role, skillLevel);
    return musician;
}