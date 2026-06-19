public abstract class NotifierDecorator implements Notifier{
    protected final Notifier wrapperNotifier;

    public NotifierDecorator(Notifier notifier){
        this.wrapperNotifier=notifier;
    }

    @Override
    public void send(String message) {
        wrapperNotifier.send(message);
    }
}
