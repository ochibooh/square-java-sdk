package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class UpsertCatalogObjectResponse {

    @JsonCreator
    public UpsertCatalogObjectResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("catalog_object") CatalogObject catalogObject,
            @JsonProperty("id_mappings") List<CatalogIdMapping> idMappings) {
        this.errors = errors;
        this.catalogObject = catalogObject;
        this.idMappings = idMappings;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject catalogObject;
    private final List<CatalogIdMapping> idMappings;

    @Override
    public int hashCode() {
        return Objects.hash(errors, catalogObject, idMappings);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpsertCatalogObjectResponse)) {
            return false;
        }
        UpsertCatalogObjectResponse upsertCatalogObjectResponse = (UpsertCatalogObjectResponse) o;
        return Objects.equals(errors, upsertCatalogObjectResponse.errors) &&
            Objects.equals(catalogObject, upsertCatalogObjectResponse.catalogObject) &&
            Objects.equals(idMappings, upsertCatalogObjectResponse.idMappings);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for CatalogObject.
     */
    @JsonGetter("catalog_object")
    public CatalogObject getCatalogObject() { 
        return this.catalogObject;
    }

    /**
     * Getter for IdMappings.
     * The mapping between client and server IDs for this upsert.
     */
    @JsonGetter("id_mappings")
    public List<CatalogIdMapping> getIdMappings() { 
        return this.idMappings;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .catalogObject(getCatalogObject())
            .idMappings(getIdMappings());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject catalogObject;
        private List<CatalogIdMapping> idMappings;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder catalogObject(CatalogObject value) {
            catalogObject = value;
            return this;
        }
        public Builder idMappings(List<CatalogIdMapping> value) {
            idMappings = value;
            return this;
        }

        public UpsertCatalogObjectResponse build() {
            UpsertCatalogObjectResponse model = new UpsertCatalogObjectResponse(errors,
                catalogObject,
                idMappings);
            model.httpContext = httpContext;
            return model;
        }
    }
}
