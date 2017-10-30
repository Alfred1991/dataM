package com.wan.dataM.admin.modular.system.service;


public interface IMenuService {


    void delMenu(Integer menuId);


    void delMenuContainSubMenus(Integer menuId);
}
