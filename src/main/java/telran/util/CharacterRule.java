package telran.util;

import java.util.function.Predicate;

public class CharacterRule {
boolean flag;
Predicate <Character> predicate;
String errorMessage;

public CharacterRule(boolean flag, Predicate <Character> predicate, String errorMessage) {
    this.flag = flag;
    this.predicate = predicate;
    this.errorMessage = errorMessage;
    }
}
