package manager;

import entity.Person;

import entity.User;

import java.util.Collection;

import org.springframework.stereotype.Service;

import entity.Group;

@Service
public interface IDirectoryManager {
    // créer un utilisateur anonyme
    User newUser();

    // chercher une personne
    Person findPerson(User user, long personId);

    // chercher un groupe
    Group findGroup(User user, long groupId);

    // chercher les personnes d'un groupe
    Collection<Person> findAllPersons(User user, long groupId);

    // identifier un utilisateur
    boolean login(String email, String password);

    // oublier l'utilisateur
    void logout(User user);
    
    public void tstring();

    // enregistrer une personne
    void savePerson(User user, Person p);
    Collection<Group>findAllGroups();
	Person getLoggedPerson();

	Collection<Person> findPersonsLike(String query);
}
