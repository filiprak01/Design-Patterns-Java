package Decorator;

//abstract/interface translator
public interface ITranslator {
    String GetName();
    int GetMaxLength();
    TranslatorType GetTranslatorType();
    String TranslateMessage(String message);
    int GetTranslationsLeft();
}
