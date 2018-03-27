package com.ags.pawn.services.agsPawnService.utils.mapper;

import com.ags.pawn.services.agsPawnService.entity.BaseEntity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by dagraw2 on 3/27/18.
 */
public class DTOtoPKDeserializer extends JsonDeserializer<BaseEntity> {
    @Override
    public BaseEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
    }
}
