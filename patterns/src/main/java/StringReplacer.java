public class StringReplacer implements StringTransformer {

    private StringDrink stringDrink;
    private char replacee;
    private char replacer;

    StringReplacer(StringDrink stringDrink, char replacee, char replacer) {
        this.stringDrink = stringDrink;
        this.replacee = replacee;
        this.replacer = replacer;
    }

    @Override
    public void execute() {
        stringDrink.setText(stringDrink.getText().replace(replacee, replacer));
        /*
        char[] chars = stringDrink.getText().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == replacee)
                chars[i] = replacer;
        }
        stringDrink.setText(new String(chars));
        */
    }

    @Override
    public void undo() {
        stringDrink.setText(stringDrink.getText().replace(replacer, replacee));
    }
}
