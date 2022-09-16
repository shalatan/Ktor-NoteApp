package com.shalatan.data

import com.shalatan.data.collections.Note
import com.shalatan.data.collections.User
import org.litote.kmongo.contains
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.setValue

//private val client = KMongo.createClient().coroutine    //use coroutine for all mongo calls
//private val database = client.getDatabase("NotesDatabase")
//
//private val users = database.getCollection<User>()
//private val notes = database.getCollection<Note>()
//
//suspend fun registerUser(user: User): Boolean {
//    return users.insertOne(user).wasAcknowledged()
//}
//
//suspend fun checkIfUserExists(email: String): Boolean {
//    return users.findOne(User::email eq email) != null
//}
//
//suspend fun checkPasswordForEmail(email: String, password: String): Boolean {
//    val actualPasswordOfUser = users.findOne(User::email eq email)?.password ?: return false
//    return actualPasswordOfUser == password
//}
//
//suspend fun getNotesForUser(email: String): List<Note> {
//    return notes.find(Note::owners contains email).toList()
//}
//
//suspend fun saveNote(note: Note): Boolean {
//    val noteExists = notes.findOneById(note.id) != null
//    return if (noteExists) {
//        notes.updateOneById(note.id, note).wasAcknowledged()
//    } else {
//        notes.insertOne(note).wasAcknowledged()
//    }
//}
//
//suspend fun deleteNoteForUser(email: String, noteId: String): Boolean {
//    val note = notes.findOne(Note::id eq noteId, Note::owners contains email)
//    note?.let {
//        val numberOfOwners = note.owners.size
//        return if (numberOfOwners > 1) {
//            //note has multiple owners, hence remove the email from list
//            val newOwners = note.owners - email
//            val updateResult = notes.updateOne(Note::id eq note.id, setValue(Note::owners, newOwners))
//            updateResult.wasAcknowledged()
//        } else {
//            //only owner, hence delete it completely
//            notes.deleteOneById(note.id).wasAcknowledged()
//        }
//    } ?: return false   //note not found, failed
//}
//
//suspend fun isOwnerOfNote(noteID: String, owner: String): Boolean {
//    val note = notes.findOneById(noteID) ?: return false
//    return owner in note.owners
//}
//
//suspend fun addOwnerToNote(noteID: String, owner: String): Boolean {
//    val owners = notes.findOneById(noteID)?.owners ?: return false
//    return notes.updateOneById(noteID, setValue(Note::owners, owners + owner)).wasAcknowledged()
//}












