package com.example.charlenes.coffee_corner.dao;

import com.example.charlenes.coffee_corner.model.Addon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRepository extends JpaRepository<Addon, Long> {
}
