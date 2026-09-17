import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while (response != 5) {
            System.out.println("Music Player:");
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. Play next song");
            System.out.println("4. Music list");
            System.out.println("5. Exit");
            System.out.print("Enter input here: ");

            response = scanner.nextInt();
            System.out.println();
            // Added this line to prevent getting a bug
            scanner.nextLine();

            switch (response) {
                case 1 -> {
                    // Add song
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();

                    playlist.addSong(new Song(title, artist));
                }
                case 2 -> {
                    // Remove song
                    if (!playlist.isEmpty()) {
                        String title;

                        System.out.print("Enter the song title you want to remove from your music playlist: ");
                        title = scanner.nextLine();

                        playlist.removeSong(title);
                    }
                    else {
                        System.out.println("Your music playlist is empty");
                    }
                }
                case 3 -> {
                    // Play next song
                    if (!playlist.isEmpty()) {
                        playlist.playNext();
                    }
                    else {
                        System.out.println("Your music playlist is empty");
                    }
                }
                case 4 -> {
                    if (!playlist.isEmpty()) {
                        playlist.displayPlaylist();
                    }
                    else {
                        System.out.println("Your music playlist is empty");
                    }
                }
                case 5 -> {
                    // Does nothing but exits out the program
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
