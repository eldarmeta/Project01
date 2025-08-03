
public class KeyFobDiagnostics {

    private boolean panicButtonWorks;
    private boolean lockButtonWorks;
    private boolean unlockButtonWorks;
    private boolean batteryIsNew;
    private boolean mechanicalKeyWorks;

    public KeyFobDiagnostics(boolean panicButtonWorks, boolean lockButtonWorks,
                             boolean unlockButtonWorks, boolean batteryIsNew,
                             boolean mechanicalKeyWorks) {
        this.panicButtonWorks = panicButtonWorks;
        this.lockButtonWorks = lockButtonWorks;
        this.unlockButtonWorks = unlockButtonWorks;
        this.batteryIsNew = batteryIsNew;
        this.mechanicalKeyWorks = mechanicalKeyWorks;
    }

    public void runDiagnostics() {
        System.out.println("Running Key Fob Diagnostics...");

        if (panicButtonWorks && (!lockButtonWorks || !unlockButtonWorks)) {
            System.out.println("Panic button works, but lock/unlock doesn't. Try replacing the battery or reprogramming the fob.");
        } else if (!panicButtonWorks && !lockButtonWorks && !unlockButtonWorks) {
            System.out.println("None of the buttons work. Battery might be dead or fob might be broken.");
        } else {
            System.out.println("All buttons are functioning properly.");
        }

        if (!batteryIsNew) {
            System.out.println("Try replacing the battery with a new one (CR2032 recommended).");
        }

        if (!mechanicalKeyWorks) {
            System.out.println("Mechanical key might be jammed. Try WD-40 or locksmith assistance.");
        }
    }

    public static void main(String[] args) {
        // Example: Panic works, Lock/Unlock doesn't, Battery is old, Mechanical key not working
        KeyFobDiagnostics diagnostics = new KeyFobDiagnostics(true, false, false, false, false);
        diagnostics.runDiagnostics();
    }
}
