package com.clean.architecture.usecase.user.find;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public class GetUserByIDUseCaseRequest implements UseCase.Request {
      private final String id;

      public GetUserByIDUseCaseRequest(String userid){
              this.id=userid;
      }

      public String getUserid(){
              return id;
      }

}
