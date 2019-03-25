public class StringCaseChanger implements StringTransformer {

    private StringDrink stringDrink;

    StringCaseChanger(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    /**
     * Strings em Java sao imutaveis, pelo que nao se pode alterar
     * os chars diretamente da string, sendo necessario criar uma variavel temporaria
     * e depois fazer set dessa string auxiliar na string inicial
     */
    @Override
    public void execute() {
        char[] chars = stringDrink.getText().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c))
                chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }

        stringDrink.setText(new String(chars));
    }

    @Override
    public void undo() {
        char[] chars = stringDrink.getText().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c))
                chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }

        stringDrink.setText(new String(chars));
    }
}
