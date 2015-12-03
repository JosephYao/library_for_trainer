import java.util.function.Consumer;

public class Transaction {
    private void begin() {

    }

    private void commit() {

    }

    private void rollback() {

    }

    public void execute(Consumer<Runnable> runnable) {
        begin();

        runnable.accept(() -> {
            rollback();
        });

        commit();
    }
}
