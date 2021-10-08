

import java.util.List;
import java.util.Scanner;

import controller.GameHelper;
import model.Game;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static GameHelper gh = new GameHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a genre: ");
			String genre = in.nextLine();
			System.out.print("Enter a game: ");
			String game = in.nextLine();
			
			Game toAdd = new Game(genre, game);
			gh.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the genre to delete: ");
			String genre = in.nextLine();
			System.out.print("Enter the game to delete: ");
			String game = in.nextLine();
			
			Game toDelete = new Game(genre, game);
			gh.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Genre");
			System.out.println("2 : Search by Game");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Game> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the genre name: ");
				String genreName = in.nextLine();
				foundItems = gh.searchForGameByGenre(genreName);
			} else {
				System.out.print("Enter the game: ");
				String gameName = in.nextLine();
				foundItems = gh.searchForGameByGame(gameName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Game l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Game toEdit = gh.searchForGameById(idToEdit);
				System.out.println("Retrieved " + toEdit.getGame() + " from " + toEdit.getGenre());
				System.out.println("1 : Update Genre");
				System.out.println("2 : Update Game");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Genre: ");
					String newStore = in.nextLine();
					toEdit.setGenre(newStore);
				} else if (update == 2) {
					System.out.print("New Game: ");
					String newItem = in.nextLine();
					toEdit.setGame(newItem);
				}

				gh.updateGame(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					gh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<Game> allItems = gh.showAllItems();
			for(Game singleItem: allItems){
				System.out.println(singleItem.returnGameDetails());
				}

		}

	}
