package com.pocket.wallet.transfomers;

public interface IParentTransformer<Rq, M,Rs> {

    M transformRequest(Rq request);

    Rs transformResponse(M model);
}
