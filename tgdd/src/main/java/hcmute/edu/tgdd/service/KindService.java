package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import hcmute.edu.tgdd.model.Kind;

public interface KindService {
	Kind insertKind(Kind newKind);
	List<Kind> getAllKind();
	
	Optional<Kind> findKindById(int id);
	Kind updateOrInsert(Kind kind);
	Kind updateKindById(Kind newKind, int id);
	
	void deleteKindById(int id);
	boolean kindExistedById(int id);
}
