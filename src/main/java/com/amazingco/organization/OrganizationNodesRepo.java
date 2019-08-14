package com.amazingco.organization;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrganizationNodesRepo extends PagingAndSortingRepository<OrganizationNodes, Long> {

    @Query(value = "SELECT * FROM Organization_Nodes WHERE path ~ CAST(:pathToSearch AS lquery)", nativeQuery = true)
    List<OrganizationNodes> findAllChildrenNodes(@Param("pathToSearch") String pathToSearch);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Organization_Nodes SET path = CAST(:destinationPath AS ltree) " +
            "|| subpath(path, :height), height = nlevel(CAST(:destinationPath AS ltree) " +
            "|| subpath(path, :height))-1 WHERE path <@ CAST(:sourcePath AS ltree)", nativeQuery = true)
    void moveNodeToDifferentParent(@Param("destinationPath") String destinationPath,
                                   @Param("sourcePath") String sourcePath,
                                   @Param("height") Integer sourceNodeHeight);

    @Query(value = "SELECT * FROM Organization_Nodes WHERE node_name = :name", nativeQuery = true)
    OrganizationNodes findNodeByName(@Param("name") String name);

}
