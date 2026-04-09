package ru.ilezzov.app.procureledger.entity.waste;

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

import lombok.Getter;

public enum WasteType {
    RENT("Аренда помещений"),
    UTILITIES("Коммунальные услуги"),
    SALARIES("Заработная плата сотрудников"),
    TAXES("Налоги и сборы"),
    MARKETING("Маркетинговые и рекламные расходы"),
    OFFICE_SUPPLIES("Канцелярские и офисные принадлежности"),
    IT_COSTS("IT‑расходы (ПО, оборудование, поддержка)"),
    TRANSPORTATION("Транспортные расходы"),
    LEGAL_AND_ACCOUNTING("Юридические и бухгалтерские услуги"),
    INSURANCE("Страхование"),
    LOAN_PAYMENTS("Платежи по кредитам"),
    EQUIPMENT_MAINTENANCE("Обслуживание и ремонт оборудования"),
    OTHER("Прочие расходы");

    @Getter
    private final String type;

    WasteType(final String type) {
        this.type = type;
    }

}
