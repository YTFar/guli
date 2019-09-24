package com.guli.message.response;

import com.mongodb.connection.QueryResult;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, com.mongodb.connection.QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
