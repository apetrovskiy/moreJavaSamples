// package com.example.mock

// import com.example.model.User
// import java.sql.{Connection, DriverManager, PreparedStatement}

// class UserRepository {
//   private val url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
//   private val connection: Connection = DriverManager.getConnection(url)

//   // Create users table
//   private val createTableSQL =
//     """
//       |CREATE TABLE users (
//       |  id UUID PRIMARY KEY,
//       |  firstName VARCHAR(255),
//       |  lastName VARCHAR(255),
//       |  age INT,
//       |  position VARCHAR(255)
//       |""".stripMargin

//   private val statement = connection.createStatement()
//   statement.execute(createTableSQL)

//   def saveUser(user: User): Unit = {
//     val insertSQL =
//       """
//         |INSERT INTO users (id, firstName, lastName, age, position)
//         |VALUES (?, ?, ?, ?, ?)
//         |""".stripMargin

//     val preparedStatement: PreparedStatement = connection.prepareStatement(insertSQL)
//     preparedStatement.setString(1, user.id.toString)
//     preparedStatement.setString(2, user.firstName)
//     preparedStatement.setString(3, user.lastName)
//     preparedStatement.setInt(4, user.age)
//     preparedStatement.setString(5, user.position)
//     preparedStatement.executeUpdate()
//   }

//   def getUserById(id: String): Option[User] = {
//     val selectSQL = "SELECT * FROM users WHERE id = ?"
//     val preparedStatement: PreparedStatement = connection.prepareStatement(selectSQL)
//     preparedStatement.setString(1, id)
//     val resultSet = preparedStatement.executeQuery()

//     if (resultSet.next()) {
//       Some(User(
//         id = UUID.fromString(resultSet.getString("id")),
//         firstName = resultSet.getString("firstName"),
//         lastName = resultSet.getString("lastName"),
//         age = resultSet.getInt("age"),
//         position = resultSet.getString("position")
//       ))
//     } else {
//       None
//     }
//   }
// }