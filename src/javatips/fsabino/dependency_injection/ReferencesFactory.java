package javatips.fsabino.dependency_injection;

public interface ReferencesFactory {
    
	int getReference(String key);
    void removeReference(String key);
}
