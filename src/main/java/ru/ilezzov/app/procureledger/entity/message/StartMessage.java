package ru.ilezzov.app.procureledger.entity.message;

/*
 * Copyright (C) 2024-2026 ILeZzoV
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ilezzov.app.procureledger.entity.AbstractEntity;
import ru.ilezzov.app.procureledger.entity.user.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "start_messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StartMessage extends AbstractEntity<Long> {
    @Column(name = "message", unique = true, nullable = false)
    private String message;

    @OneToMany(mappedBy = "startMessage", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public void addUser(final User user) {
        this.users.add(user);
        user.setStartMessage(this);
    }
}
