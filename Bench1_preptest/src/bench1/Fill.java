package bench1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fill {

	static void fill (Connection conni, PreparedStatement prepStmt, int n)
			throws SQLException {		
		
		//Schleife um die BRANCHES-Relation zu fuellen
		prepStmt = conni.prepareStatement(Statements.branches);
		
		prepStmt.setString(2, "nameMit20Buchstaben!");
		prepStmt.setInt(3, 0);
		prepStmt.setString(4, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrst");
		
		for(int i=0;i<n;i++){
			prepStmt.setInt (1, i + 1);
			prepStmt.executeUpdate();
		}
		
		// Schleife um die TELLERS-Relation zu f�llen
		prepStmt = conni.prepareStatement(Statements.tellers);
		
		prepStmt.setString(2, "nameMit20Buchstaben!");
		prepStmt.setInt(3, 0);
		prepStmt.setString(5, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop");
		
		for(int i=0;i<n*10;i++){
			prepStmt.setInt (1, i + 1);
			prepStmt.setInt(4, (int) (1+(Math.random()*n)));
			prepStmt.executeUpdate();
		}
		
		// Schleife um die ACCOUNTS-Relation zu f�llen
		prepStmt = conni.prepareStatement(Statements.accounts);
		
		prepStmt.setString(2, "nameMit20Buchstaben!");
		prepStmt.setInt(3, 0);
		prepStmt.setString(5, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop");
		
		for(int i=0;i<n*100000;i++){
			
			if (i % 1000 == 0)
				System.out.println(i);
			
			prepStmt.setInt (1, i + 1);
			prepStmt.setInt(4, (int) (1+(Math.random()*n)));
			prepStmt.executeUpdate();

		}
	}
}
