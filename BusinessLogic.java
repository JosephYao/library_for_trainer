public class BusinessLogic {

    public void someLogicWithTwoTableDataInsert() {

        new Transaction().execute((Runnable runWhenInsertFailed) -> {

            FirstDataRepo firstRepo = new FirstDataRepo();
            FirstObject firstObject = new FirstObject();
            firstRepo.insert(firstObject, runWhenInsertFailed);

            SecondDataRepo secondRepo = new SecondDataRepo();
            SecondObject secondObject = new SecondObject();
            secondRepo.insert(secondObject, runWhenInsertFailed);

        });

    }

}
