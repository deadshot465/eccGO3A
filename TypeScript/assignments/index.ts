import Executable from "../shared/Executable.ts";
import K01 from "./K01.ts";
import K02 from "./K02.ts";
import K03 from "./K03.ts";
import K04 from "./K04.ts";
import K05 from "./K05.ts";
import K06 from "./K06.ts";
import K07 from "./K07.ts";
import K08 from "./K08/K08.ts";

export const questions: Executable[] = [
    new K01(), new K02(), new K03(), new K04(),
    new K05(), new K06(), new K07(), new K08()
];