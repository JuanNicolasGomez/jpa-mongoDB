package eci.cosw.data;

import eci.cosw.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReposiroty  extends MongoRepository<User, String> {
}
