public class BusinessLogic {

    public void someLogicWithTwoTableDataInsert() {

        new Transaction().execute(() -> {

            FirstDataRepo firstRepo = new FirstDataRepo();
            FirstObject firstObject = new FirstObject();
            firstRepo.insert(firstObject);

            SecondDataRepo secondRepo = new SecondDataRepo();
            SecondObject secondObject = new SecondObject();
            secondRepo.insert(secondObject);

        });

    }

}
