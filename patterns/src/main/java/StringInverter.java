public class StringInverter implements StringTransformer {

    private StringDrink stringDrink;

    StringInverter(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    @Override
    public void execute() {
        // append a string into StringBuilder input1
        //stringBuilder.append(this.stringDrink.getText());
        StringBuilder stringBuilder = new StringBuilder(this.stringDrink.getText());

        // reverse StringBuilder input1
        stringBuilder = stringBuilder.reverse();

        stringDrink.setText(stringBuilder.toString());

        /* Using StringBuffer
        StringBuffer sb = new StringBuffer(this.stringDrink.getText());
        sb.reverse();
        stringDrink.setText(sb.toString());
        */
    }

    @Override
    public void undo() {
        //stringBuilder.append(this.stringDrink.getText());
        StringBuilder stringBuilder = new StringBuilder(this.stringDrink.getText());

        // reverse StringBuilder input1
        stringBuilder = stringBuilder.reverse();

        stringDrink.setText(stringBuilder.toString());
    }
}
