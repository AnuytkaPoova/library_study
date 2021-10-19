package com.a_ches.buttoncounterapp

interface IListPresenter<V : IItemView> {
    //наследуется от IItemView который твечает за хранение позиции в нашем списке (var pos)
    //презентер для списка
    //биндит вьюху
    //получает количество вьюх в списке
    //и добавляет кликлистенер
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}