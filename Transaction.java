public class Transaction {
    private void begin() {

    }

    private void commit() {

    }

    private void rollback() {

    }

    public void execute(Runnable runnable) {
        try {
            begin();

            runnable.run();

            commit();
        } catch (Exception e) {
            rollback();
        }
    }
}
