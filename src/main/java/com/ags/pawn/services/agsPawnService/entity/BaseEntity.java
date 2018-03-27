package com.ags.pawn.services.agsPawnService.entity;

/**
 * Created by dagraw2 on 3/25/18.
 */

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
// Ignore unrecognized properties during deserialization (no effect on serialization)
@JsonIgnoreProperties(ignoreUnknown = true)
// Use the "id" field to resolve circular references
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public abstract class BaseEntity {

    private UUID id;
    private Long dbLockVersion;
    private String modifiedBy;
    private String createdBy;
    private Date modifiedDate;
    private Date createdDate;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    public UUID getId()
    {
        return id;
    }

    /**
     * Called by JPA to make sure we have assigned a primary before persisting the entity
     */
    @PrePersist
    private void verifyPrimaryKeyAssigned()
    {
        getId();
    }

    /**
     * Get the db-lock-version used for optimistic locking.
     */
    @Version
    @Column(name="DB_LOCK_VERSION")
    public Long getDbLockVersion()
    {
        return dbLockVersion;
    }

    /**
     * Allows setting of a type-4 UUID.<BR>
     * The use of this method is discouraged and it will be removed in a later release.
     * @param id : Non-null type-4 UUID
     */
    public void setId(UUID id)
    {
//        if(id == null) {
//            throw new IllegalStateException("Expected a non-null ID");
//        } else if(id.version() != 4){
//            throw new IllegalStateException("UUID value %s provided is not of type-4. DAL only supports type-4 UUID"+id.toString());
//        }
        this.id = id;
    }

    @Column(name = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Modified_Date: Date column updated automatically with
     * DB-date during insert as well as update operations.
     *
     * COALESCE and CURRENT_TIMESTAMP have been chosen for
     * custom-SQL because they are supported by all major
     * DBs like Oracle, PostgreSQL and MySQL
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    @UpdateTimestamp
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Created_Date: Date column updated automatically with
     * DB-date during insert operations only.
     *
     * COALESCE and CURRENT_TIMESTAMP have been chosen for
     * custom-SQL because they are supported by all major
     * DBs like Oracle, PostgreSQL and MySQL
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false) // This annotation makes sure that this column is untouched in update queries (So it's used only in insert queries)
    @CreationTimestamp
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setDbLockVersion(Long dbLockVersion) {
        this.dbLockVersion = dbLockVersion;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}