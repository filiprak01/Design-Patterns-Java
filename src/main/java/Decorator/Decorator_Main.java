package Decorator;

public class Decorator_Main {

    public static void main(String[] args) {

        ITranslator[] translators =
                {
                        new Translator("First" ,100),
                        new Translator("Second",100),
                        new Translator("Third" ,100),
                        new Translator("Spare" ,100),
                        new Translator("Fourth",100),
                        new Translator("Fast",100),
                        new Translator("Old",100),
                        new Translator("Rapid" ,100),
                        new Translator("Square",100)
                };
        System.out.println("----------Normal translators----------");
        for (ITranslator t: translators
             ) {
            TestTranslator(t, 4,"my simple message that is too long for some decoders but other can process it easily");
        }
        System.out.println("----------Decorators----------");
        for (ITranslator t: translators
        ) {
            System.out.println("----------"+t.GetName()+"----------");
            Decorator(t,"my simple message that is too long for some decoders but other can process it easily",2);
        }
    }

    private static void TestTranslator(ITranslator translator, int tries, String message){
        System.out.println("Name:"+ translator.GetName());
        System.out.println("MaxLength:"+ translator.GetMaxLength());
        System.out.println("Type:"+ translator.GetTranslatorType());
        System.out.println("Translations left:"+ translator.GetTranslationsLeft());
        if (tries > 0)
            System.out.println("First try:"+ translator.TranslateMessage(message));
        if (tries > 1)
        {
            for (int i = 0; i < tries - 2; i++)
                translator.TranslateMessage(message);
            System.out.println("Last try: " +translator.TranslateMessage(message));
        }
        System.out.println();
    }
    private static void Decorator(ITranslator translator, String message, int offset){
        ITranslator broken = TranslatorModificator.SetTranslatorToBroken(translator,message);
        TestTranslator(broken, 2, message);
        ITranslator smart = TranslatorModificator.MakeTranslatorSmart(translator);
        TestTranslator(smart, 2, message);
        ITranslator encrypted = TranslatorModificator.EncryptMessages(translator,offset,20);
        TestTranslator(encrypted, 2, message);
        String encoded_message = encrypted.TranslateMessage(message);
        ITranslator decrypted = TranslatorModificator.DecryptMessages(encrypted, offset);
        TestTranslator(decrypted, 2, encoded_message);
        ITranslator encrypted1 = TranslatorModificator.EncryptMessages(smart,offset,20);
        String encoded_message1 = encrypted.TranslateMessage(message);
        TestTranslator(encrypted1, 2, message);
        ITranslator decrypted1 = TranslatorModificator.DecryptMessages(encrypted, offset);
        TestTranslator(decrypted1, 2, encoded_message1);
    }
}
