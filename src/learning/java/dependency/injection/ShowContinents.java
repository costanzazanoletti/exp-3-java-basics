package learning.java.dependency.injection;

public class ShowContinents {

  // mostrare l'elenco di tutti i continenti
  private ContinentsRepositoryInterface repo;

  public ShowContinents(String choice) {
    /*this.repo = new ContinentDatabaseRepository();*/
    /*this.repo = new ContinentsMemoryRepository();*/
    this.repo = ContinentFactory.getContinentRepository(choice);
  }

  public void show() {
    for (String c : repo.getContinents()) {
      System.out.println(c);
    }
  }

}
