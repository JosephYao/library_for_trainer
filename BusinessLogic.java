public class BusinessLogic {

    public void someLogicWithTwoTableDataInsert() {

        Transaction transaction = new Transaction();

        transaction.begin();

        try {

            FirstDataRepo firstRepo = new FirstDataRepo();
            FirstObject firstObject = new FirstObject();
            firstRepo.insert(firstObject);

            SecondDataRepo secondRepo = new SecondDataRepo();
            SecondObject secondObject = new SecondObject();
            secondRepo.insert(secondObject);

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }

    }

}
