package Decorator;

//concrete translator
public class Translator implements ITranslator {
    private  String name;
    private  int translationNumber;

    Translator(String name, int translationNumber) {
        this.name = name;
        this.translationNumber = translationNumber;
    }

    private  int currentTranslations = 0;
    @Override
    public String GetName() {
        return name;
    }

    @Override
    public int GetMaxLength() {
        return 30;
    }

    @Override
    public TranslatorType GetTranslatorType() {
        return TranslatorType.Ordinary;
    }

    @Override
    public String TranslateMessage(String message) {
        if(currentTranslations <= translationNumber){
            if(message.length() > GetMaxLength()){
                return message.substring(0,GetMaxLength());
            }
            return message;
        }
        return "";
    }

    @Override
    public int GetTranslationsLeft() {
        return translationNumber - currentTranslations;
    }
}
