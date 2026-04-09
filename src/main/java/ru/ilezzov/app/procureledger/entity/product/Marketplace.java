package ru.ilezzov.app.procureledger.entity.product;

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

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marketplaces")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Marketplace extends AbstractEntity<Long> {
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @OneToMany(mappedBy = "marketplace", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    public void addProduct(final Product product) {
        this.products.add(product);
        product.setMarketplace(this);
    }
}
