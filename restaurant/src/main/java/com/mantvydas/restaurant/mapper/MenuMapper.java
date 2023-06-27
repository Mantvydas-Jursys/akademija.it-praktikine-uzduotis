package com.mantvydas.restaurant.mapper;

import com.mantvydas.restaurant.model.Menu;
import com.mantvydas.restaurant.rest.dto.MenuDto;

import java.util.HashSet;

public class MenuMapper {

    public static Menu menuDtoToMenu (MenuDto menuDto) {
        return new Menu(menuDto.getMenuTitle(), new HashSet<>());
    }
}
