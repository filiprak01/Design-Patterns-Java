package Decorator;

//abstract decorator
public abstract class Modificator implements ITranslator {
    private ITranslator translator;

    Modificator(ITranslator translator) {
        this.translator = translator;
    }
    public void SetTranslator(ITranslator translator){
        this.translator = translator;
    }

    @Override
    public String GetName() {
        return translator.GetName();
    }

    @Override
    public int GetMaxLength() {
        return translator.GetMaxLength();
    }

    @Override
    public TranslatorType GetTranslatorType() {
        return translator.GetTranslatorType();
    }

    @Override
    public String TranslateMessage(String message) {
        return translator.TranslateMessage(message);
    }

    @Override
    public int GetTranslationsLeft() {
        return translator.GetTranslationsLeft();
    }
}
