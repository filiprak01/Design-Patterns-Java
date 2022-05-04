package Decorator;

class TranslatorModificator {
    static ITranslator SetTranslatorToBroken(ITranslator translator, String message)
    {
        return new Broke(translator, message);
    }

    static ITranslator MakeTranslatorSmart(ITranslator translator)
    {
        return new Smart(translator);
    }

    static ITranslator EncryptMessages(ITranslator translator, int offset, int maxCallsNumber)
    {
        return new Encryption(translator, offset, maxCallsNumber);
    }

    static ITranslator DecryptMessages(ITranslator translator, int offset)
    {
        return new Decryption(translator, offset);
    }
    //create concrete Decorators
    private static class Decryption extends Modificator {
        private int offset;
        Decryption(ITranslator translator, int offset) {
            super(translator);
            this.offset = offset;
        }

        @Override
        public TranslatorType GetTranslatorType() {
            return TranslatorType.Decryption;
        }

        @Override
        public String TranslateMessage(String message) {
            StringBuilder decrypt = new StringBuilder();
            for(int i = 0; i < message.length(); i++){
                decrypt.append(DecryptLetter(message.charAt(i), offset));
            }
            return decrypt.toString();
        }
        char DecryptLetter(char c, int offset){
            int letter = c;
            letter-=offset;
            return (char)(letter);
        }
    }
    private static class Encryption extends Modificator{
        private int offset;
        private int translations;
        Encryption(ITranslator translator, int offset, int maxCallNumber) {
            super(translator);
            this.offset = offset;
            this.translations = maxCallNumber;
        }

        @Override
        public TranslatorType GetTranslatorType() {
            return TranslatorType.Encryption;
        }

        @Override
        public String TranslateMessage(String message) {
            if(translations <=0 ){
                return "Decorator.Translator auto-destroyed";
            }
            StringBuilder encrypted = new StringBuilder();
            for(int i = 0; i < message.length(); i++){
                encrypted.append(EncryptLetter(message.charAt(i), offset));
            }

            return encrypted.toString();
        }
        char EncryptLetter(char c, int offset){
            int letter = c;
            letter+= offset;
            return (char)(letter);
        }
    }
    private static class Smart extends Modificator{
        Smart(ITranslator translator) {
            super(translator);
        }


        @Override
        public TranslatorType GetTranslatorType() {
            return TranslatorType.Smart;
        }

        @Override
        public String TranslateMessage(String message) {
            StringBuilder mess_send = new StringBuilder();
            int send = 0;
            while(message.length()-send > 0){
                int message_size = Math.min(message.length() - send, super.GetMaxLength());
                mess_send.append(super.TranslateMessage(message.substring(send, send+message_size)));
                send+= message_size;
            }
            return mess_send.toString();
        }
    }
    private static class Broke extends Modificator {
        private String message;
        Broke(ITranslator translator,String message) {
            super(translator);
            this.message = message;
        }

        @Override
        public int GetMaxLength() {
            return 0;
        }

        @Override
        public TranslatorType GetTranslatorType() {
            return TranslatorType.Broken;
        }

        @Override
        public String TranslateMessage(String message) {
            return this.message;
        }

        @Override
        public int GetTranslationsLeft() {
            return 0;
        }
    }
}
