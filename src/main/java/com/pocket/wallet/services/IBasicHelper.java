package com.pocket.wallet.services;

import com.pocket.wallet.entities.BasicEntity;
import com.pocket.wallet.models.IBasicModel;

public interface IBasicHelper<E extends BasicEntity, M extends IBasicModel> {


    E mapToEntity(M model);

    M mapToModel(E entity);


}
