package ru.ilezzov.app.procureledger.entity.supplier;

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

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ilezzov.app.procureledger.entity.AbstractEntity;
import ru.ilezzov.app.procureledger.entity.product.Product;
import ru.ilezzov.app.procureledger.entity.purchase.Purchase;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Supplier extends AbstractEntity<Long> {
    private String name;

    @Embedded
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchases = new ArrayList<>();

    public void addProduct(final Product product) {
        this.products.add(product);
        product.setSupplier(this);
    }

    public void addPurchase(final Purchase purchase) {
        this.purchases.add(purchase);
        purchase.setSupplier(this);
    }

}
