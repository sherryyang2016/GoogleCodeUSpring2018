// Activity abstract class
// Created by Naomi
//
// An Activity represents an event such as the creation of a new chat, a new
// user, a message in a chat. Subclasses should override the toString method
// in order to return the String that would be displayed for the activity.

package codeu.model.data;

import codeu.model.data.User;
import codeu.model.store.basic.UserStore;
import java.time.Instant;
import java.util.UUID;

public abstract class Activity {

  private final Instant creation;
  private final UUID actorId;

  //constructor for activity should be called by subclass
  protected Activity(UUID actor, Instant creation) {
    this.actorId = actor;
    this.creation = creation;
  }

  public User getActor() {
    return UserStore.getInstance().getUser(actorId);  
  }

  public UUID getActorId() {
    return actorId;
  }

  public Instant getCreationTime() {
      return creation;
  }
}
