package tech.antee.compose_multimodule_template.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MockEntity(
    @PrimaryKey val id: String
)
